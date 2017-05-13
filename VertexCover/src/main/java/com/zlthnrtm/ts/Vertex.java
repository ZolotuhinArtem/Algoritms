package com.zlthnrtm.ts;

import java.util.Objects;

public class Vertex implements Copyable<Vertex>{
    
    private Integer index;
    
    private Integer valency;

    public Vertex() {
        this.index = -1;
        this.valency = 0;
    }

    public Vertex(Integer index) {
        this.index = index;
        this.valency = 0;
    }

    public Vertex(Integer index, Integer valency) {
        this.index = index;
        this.valency = valency;
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
        if (!this.index.equals(other.index)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vertex{" + "index=" + index + '}';
    }

    public Integer getValency() {
        return valency;
    }

    public void setValency(Integer valency) {
        this.valency = valency;
    }

    @Override
    public Vertex getCopy() {
        return new Vertex(this.index, this.valency);
    }
    
    
}
