package preparation.util;

import java.util.Objects;

public class VNode {
    public int source;
    public int destination;
    public int distance;

    public VNode(int source, int destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public VNode(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VNode vNode = (VNode) o;
        return source == vNode.source &&
                destination == vNode.destination &&
                distance == vNode.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, distance);
    }

    @Override
    public String toString() {
        return "VNode{" +
                "source=" + source +
                ", destination=" + destination +
                ", distance=" + distance +
                '}';
    }
}
