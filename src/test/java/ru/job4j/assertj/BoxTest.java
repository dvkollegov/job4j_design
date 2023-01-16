package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .contains("Sph")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(10, 0);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .containsIgnoringCase("unknown")
                .isEqualTo("Unknown object");
    }

    @Test
    void isThisNumberOfVertices4() {
        Box box = new Box(4, 4);
        int result = box.getNumberOfVertices();
        assertThat(result).isLessThan(5)
                .isGreaterThan(3)
                .isEqualTo(4);
    }

    @Test
    void isThisNumberOfVerticesMinus1() {
        Box box = new Box(4, 0);
        int result = box.getNumberOfVertices();
        assertThat(result).isLessThan(0)
                .isGreaterThan(-2)
                .isEqualTo(-1);
    }

    @Test
    void isThisExistTrue() {
        Box box = new Box(4, 4);
        boolean result = box.isExist();
        assertThat(result).isNotEqualTo(-1)
                .isTrue();
    }

    @Test
    void isThisExistFalse() {
        Box box = new Box(4, 0);
        boolean result = box.isExist();
        assertThat(result).isNotEqualTo(1)
                .isFalse();
    }

    @Test
    void isThisAreaSphere() {
        Box box = new Box(0, 5);
        double result = box.getArea();
        assertThat(result).isEqualTo(314.15d, withPrecision(0.01))
                .isGreaterThan(314.14)
                .isLessThan(314.16);
    }

    @Test
    void isThisAreaCube() {
        Box box = new Box(8, 5);
        double result = box.getArea();
        assertThat(result).isEqualTo(150.0d, withPrecision(0.1))
                .isGreaterThan(149.0d)
                .isLessThan(151.0d);
    }
}