import lt.itakademija.*;

import java.util.Iterator;

public class Test extends BaseTest {
    
    @Override
    protected DocumentOrganizer createDocumentOrganizer(DocumentTypeDetector documentTypeDetector) {
        return new MyDocumentOrganizer(documentTypeDetector);
    }

    @Override
    protected DocumentProducer createDocumentProducer(Iterator<Document> iterator) {
        return new MyDocumentProducer(iterator);
    }

    @Override
    protected DocumentConsumer createDocumentConsumer(FileRepository fileRepository) {
        return new MyDocumentConsumer(fileRepository);
    }
}
