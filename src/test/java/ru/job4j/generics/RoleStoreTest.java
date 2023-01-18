package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRolenameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("programmer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        store.add(new Role("1", "analyst"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("programmer");
    }

    @Test
    void whenReplaceThenRolenameIsMaxim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        store.replace("1", new Role("1", "analyst"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("analyst");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeUsername() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        store.replace("10", new Role("10", "analyst"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("programmer");
    }

    @Test
    void whenDeleteRoleThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("programmer");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        boolean rsl = store.replace("1", new Role("1", "analyst"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        boolean rsl = store.replace("10", new Role("10", "analyst"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "programmer"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}