import lt.itakademija.*;

public class MyDocumentOrganizer implements DocumentOrganizer {

    private DocumentTypeDetector documentTypeDetector;
    private long totalDocuments;
    private long totalLines;

    public MyDocumentOrganizer(DocumentTypeDetector documentTypeDetector) {
        this.documentTypeDetector = documentTypeDetector;
    }

    @Override
    public long getTotalCount() {
        return totalDocuments;
    }

    @Override
    public long getTotalLinesCount() {
        return totalLines;
    }

    private void updateCount(Document document) {
        totalDocuments++;
        totalLines += document.getLines().size();
    }

    @Override
    public void organize(DocumentProducer documentProducer, DocumentConsumer documentConsumer) {
        if (documentProducer == null || documentConsumer == null) {
            throw new IllegalArgumentException();
        } else {
            boolean organizing = true;
            while (organizing) {
                Document nextDocument = documentProducer.get();
                if (nextDocument != null) {
                    updateCount(nextDocument);
                    DocumentType documentType = documentTypeDetector.detect(nextDocument);
                    switch (documentType) {
                        case SPAM:
                            documentConsumer.consumeSpam(nextDocument);
                            break;
                        case IMPORTANT:
                            documentConsumer.consumeImportant(nextDocument);
                            break;
                        case ORDINARY:
                            documentConsumer.consumeOrdinary(nextDocument);
                            break;
                        case UNKNOWN:
                            throw new UnknownDocumentTypeException("Unknown document type passed.");
                        default:
                            throw new IllegalArgumentException();
                    }
                } else {
                    organizing = false;
                }
            }
        }
    }
}
