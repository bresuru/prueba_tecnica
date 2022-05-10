package com.consult.customer.util;

/**
 * Clase que contiene los tipos de documentos disponibles
 */
public enum DocumentTypeEnum {
    PASAPORTE("P"),
    CEDULA("C");

    private final String description;

    DocumentTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Devuelve el enumerador a buscar
     * @param value
     * @return
     */
    public static DocumentTypeEnum findByValue(String value){
        for(DocumentTypeEnum vc : values()){
            if(vc.getDescription().equals(value)){
                return vc;
            }
        }
        return null;
    }

}
