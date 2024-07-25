package org.jqassistant.plugin.rdbms.impl.scanner;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Properties;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.scanner.api.Scope;

import org.jqassistant.plugin.rdbms.api.RdbmsScope;
import org.jqassistant.plugin.rdbms.api.model.ConnectionDescriptor;
import org.jqassistant.plugin.rdbms.api.model.SchemaDescriptor;
import schemacrawler.tools.options.InfoLevel;

public class ConnectionUriScannerPlugin extends AbstractSchemaScannerPlugin<URI, ConnectionDescriptor> {

    @Override
    public boolean accepts(URI item, String path, Scope scope) throws IOException {
        return RdbmsScope.CONNECTION.equals(scope);
    }

    @Override
    public ConnectionDescriptor scan(URI item, String path, Scope scope, Scanner scanner) throws IOException {
        List<SchemaDescriptor> schemaDescriptors = scanConnection(item.toString(), null, null, InfoLevel.standard.name(), null, new Properties(), scanner
                .getContext().getStore());
        ConnectionDescriptor connectionDescriptor = scanner.getContext().getStore().create(ConnectionDescriptor.class);
        connectionDescriptor.getSchemas().addAll(schemaDescriptors);
        return connectionDescriptor;
    }
}
