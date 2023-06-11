package com.devsuperior.dslist.dto;

public class ReplacementDTO {
    private int originIndex;
    private int destinationIndex;

    public ReplacementDTO(int originIndex, int destinationIndex) {
        this.originIndex = originIndex;
        this.destinationIndex = destinationIndex;
    }

    public int getOriginIndex() {
        return originIndex;
    }

    public int getDestinationIndex() {
        return destinationIndex;
    }
}
