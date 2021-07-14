package de.lemona.android.guice;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public class Ids {

    private Ids() {
        throw new IllegalStateException("Do not construct");
    }

    public static Id id(int id) {
        return new IdImpl(id);
    }

    /* ====================================================================== */

    @SuppressWarnings("all")
    private static class IdImpl implements Id, Serializable {

        private final int value;

        private IdImpl(int value) {
            this.value = value;
        }

        @Override
        public int value() {
            return this.value;
        }

        @Override
        public int hashCode() {
            // This is specified in java.lang.Annotation.
            return (127 * "value".hashCode()) ^ Integer.valueOf(value).hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o == this) return true;
            try {
                return ((Id) o).value() == this.value;
            } catch (final ClassCastException exception) {
                return false;
            }
        }

        @Override
        public String toString() {
            return "@" + Id.class.getName() + "(value=" + value + ")";
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return Id.class;
        }
    }
}
