
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.codec.DecodeMonitor;
import org.apache.james.mime4j.message.DefaultBodyDescriptorBuilder;
import org.apache.james.mime4j.parser.ContentHandler;
import org.apache.james.mime4j.parser.MimeStreamParser;
import org.apache.james.mime4j.stream.BodyDescriptorBuilder;
import org.apache.james.mime4j.stream.MimeConfig;
import tech.blueglacier.email.Attachment;
import tech.blueglacier.parser.CustomContentHandler;

import java.io.*;
import java.util.List;

public class Email {
    public static void main(String[] args) throws IOException, MimeException {
        ContentHandler contentHandler = new CustomContentHandler();

        MimeConfig mime4jParserConfig = MimeConfig.DEFAULT;
        BodyDescriptorBuilder bodyDescriptorBuilder = new DefaultBodyDescriptorBuilder();
        MimeStreamParser mime4jParser = new MimeStreamParser(mime4jParserConfig, DecodeMonitor.SILENT,bodyDescriptorBuilder);
        mime4jParser.setContentDecoding(true);
        mime4jParser.setContentHandler(contentHandler);

        File file = new File("D:\\em.eml");

        InputStream mailIn = new FileInputStream(file);
        mime4jParser.parse(mailIn);

        tech.blueglacier.email.Email email = ((CustomContentHandler) contentHandler).getEmail();

        List<Attachment> attachments =  email.getAttachments();

        Attachment calendar = email.getCalendarBody();
        Attachment htmlBody = email.getHTMLEmailBody();
        Attachment plainText = email.getPlainTextEmailBody();
        System.out.println(plainText.getAttachmentName());
        String to = email.getToEmailHeaderValue();
        String cc = email.getCCEmailHeaderValue();
        String from = email.getFromEmailHeaderValue();
    }
}
