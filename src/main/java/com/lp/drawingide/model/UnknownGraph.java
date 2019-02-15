package com.lp.drawingide.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UnknownGraph {
    private List<UnknownNode> nodes;
    private List<UnknownRelationship> relationships;

    public UnknownGraph() {
        nodes = new ArrayList<>();
        relationships = new ArrayList<>();
    }

}
