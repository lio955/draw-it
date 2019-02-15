package com.lp.drawingide.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UnknownGraph {
    private List<UnknownNode> nodes = new ArrayList<>();
    private List<UnknownRelationship> relationships = new ArrayList<>();

}
