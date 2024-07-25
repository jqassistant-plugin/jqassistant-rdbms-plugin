package org.jqassistant.plugin.rdbms.api.model;

import com.buschmais.jqassistant.core.store.api.model.Descriptor;

public interface OnColumnDescriptor extends Descriptor {

    ColumnDescriptor getColumn();

    int getIndexOrdinalPosition();

    void setIndexOrdinalPosition(int indexOrdinalPosition);

    String getSortSequence();

    void setSortSequence(String name);
}
