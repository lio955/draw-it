package com.lp.drawingide.generator;

import com.lp.drawingide.model.UnknownGraph;
import com.lp.drawingide.model.UnknownNode;

public class CypherDataGenerator {

    public static String translateToCypher(final UnknownGraph unknownGraph) {
        String cypher = "";
        for (UnknownNode unknownNode : unknownGraph.getNodes()) {
            cypher = cypher + "\n CREATE (" + unknownNode.getAbstractShape().getText() + ");";
        }
        return cypher;
    }
}
