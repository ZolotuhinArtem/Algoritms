package com.zlthnrtm.ts;

import java.util.Objects;

public class Edge {
    
    private Vertex vertex1;
    
    private Vertex vertex2;

    public Edge() {}

    public Edge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }
    
    public boolean hasVertex(Vertex vertex) {
        return (vertex1.equals(vertex) || vertex2.equals(vertex));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.vertex1);
        hash = 23 * hash + Objects.hashCode(this.vertex2);
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
        final Edge other = (Edge) obj;
        if (!Objects.equals(this.vertex1, other.vertex1) && !Objects.equals(this.vertex1, other.vertex2)) {
            return false;
        }
        if (!Objects.equals(this.vertex2, other.vertex2) && !Objects.equals(this.vertex2, other.vertex1)) {
            return false;
        }
        return true;
    }
    
    
    
}
