package com.lp.drawingide.generator;

import com.lp.drawingide.model.UnknownGraph;
import com.lp.drawingide.model.UnknownNode;
import com.lp.drawingide.model.UnknownRelationship;

public class CypherDataGenerator {

    public static String translateToCypher(final UnknownGraph unknownGraph) {
        String cypher = "";
        for (UnknownNode unknownNode : unknownGraph.getNodes()) {
            cypher = cypher + "\n CREATE (" + unknownNode.getAbstractShape().getText() + ");";
        }

        for (UnknownRelationship unknownRelationship : unknownGraph.getRelationships()) {
            cypher = cypher + "\n MATCH (A : " + unknownRelationship.getNodeA().getAbstractShape().getText() + ")";
            cypher = cypher + "\n     , (B : " + unknownRelationship.getNodeB().getAbstractShape().getText() + ")";
            cypher = cypher + "\n CREATE (A)-[:" + unknownRelationship.getAbstractShape().getText() + "]->(B);";
        }
        return cypher;
    }
}
