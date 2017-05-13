package com.zlthnrtm.ts;

import java.util.Objects;

public class Vertex {
    
    private Integer index;

    public Vertex() {
        this.index = -1;
    }

    public Vertex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.index);
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.index, other.index)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vertex{" + "index=" + index + '}';
    }
    
}
