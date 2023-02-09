package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Dima Kollegov");
    }

    @Test
    void whenPairComment() {
        String path = "data/pair_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Dima Kollegov");
    }

    @Test
    void whenPairEmpty() {
        String path = "data/pair_empty.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Dima Kollegov");
    }

    @Test
    void whenKeySplitValue() {
        String path = "data/pair_split_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Dima=Kollegov");
    }

    @Test
    void whenKeySplitValueEndsSplit() {
        String path = "data/pair_split_value_ends_split.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Dima=Kollegov=");
    }

    @Test
    void whenKeyException() {
        String path = "data/pair_key_exception.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }

    @Test
    void whenValueException() {
        String path = "data/pair_value_exception.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }

    @Test
    void whenKeyAndValueException() {
        String path = "data/pair_key_and_value_exception.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }

    @Test
    void whenNotSymbolException() {
        String path = "data/pair_not_symbol_exception.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, config::load);
        assertThat(exception).message();
    }
}