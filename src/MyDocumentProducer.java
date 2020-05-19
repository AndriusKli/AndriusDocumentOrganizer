import lt.itakademija.Document;
import lt.itakademija.DocumentProducer;

import java.util.Iterator;

public class MyDocumentProducer implements DocumentProducer {
    private Iterator<Document> documents;

    public MyDocumentProducer(Iterator<Document> documents) {
        this.documents = documents;
    }

    @Override
    public Document get() {
        if (documents.hasNext()) {
            return documents.next();
        } else {
            return null;
        }
    }
}
