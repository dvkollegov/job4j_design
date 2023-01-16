package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkValidateNotSymbol() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this name: test does not contain the symbol \"=\"");
    }

    @Test
    void checkValidateNotSymbolKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=test"))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkValidateNotSymbolValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("test="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this name: test= does not contain a value");
    }

    @Test
    void checkParseIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }
}