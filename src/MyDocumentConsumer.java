import lt.itakademija.Document;
import lt.itakademija.DocumentConsumer;
import lt.itakademija.FileRepository;

public class MyDocumentConsumer implements DocumentConsumer {
    private FileRepository fileRepository;

    public MyDocumentConsumer(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void consumeSpam(Document document) {
        fileRepository.putSpam(document);
    }

    @Override
    public void consumeImportant(Document document) {
        fileRepository.putImportant(document);
    }

    @Override
    public void consumeOrdinary(Document document) {
        fileRepository.putOrdinary(document);
    }
}
