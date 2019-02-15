package com.lp.drawingide.model;

import lombok.Data;

@Data
public class UnknownRelationship {
    private AbstractShape abstractShape;
    private  UnknownNode nodeA;
    private  UnknownNode nodeB;
}
