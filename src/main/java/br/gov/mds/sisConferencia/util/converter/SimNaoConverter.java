package br.gov.mds.sisConferencia.util.converter;

import javax.persistence.AttributeConverter;

public class SimNaoConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        }
        if(attribute) {
            return 'S';
        }else {
            return 'N';
        }
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.equals('S');
    }

}
