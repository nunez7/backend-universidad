package com.vass.universidad.repositorios;
import com.vass.universidad.datos.DatosDummy;
import com.vass.universidad.entities.Carrera;
import com.vass.universidad.repositories.CarreraRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CarreraRepositoryTest {

    @Autowired
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        carreraRepository.save(DatosDummy.carrera01(false));
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03(false));
    }

    @AfterEach
    void tearDown() {
        carreraRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscar Carreras por nombre")
    void findCarrerasByNombreContains() {
        //given
        /*carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //when
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");

        //then
        assertThat(((List<Carrera>)expected).size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar Carreras por nombre NO case sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {
        //given
        /*carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera03());
        carreraRepository.save(DatosDummy.carrera02());*/

        //when
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");

        //then
        assertThat(expected.size() == 2).isTrue();

    }

    @Test
    @DisplayName("Buscar Carreras mayor a N años")
    void findCarrerasByCantidadAniosAfter() {
        //given
        /*carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera03());
        carreraRepository.save(DatosDummy.carrera02());*/

        //when
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadCuatrimestresAfter(4);

        //then
        assertThat(expected.size() == 2).isTrue();
    }

}
