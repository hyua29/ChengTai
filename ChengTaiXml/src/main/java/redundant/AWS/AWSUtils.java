package redundant.AWS;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

import java.util.Date;

public class AWSUtils {

    private BasicAWSCredentials awsCreds;
    private AmazonS3Client s3Client;

    public AWSUtils(String id, String pw) {
        awsCreds = new BasicAWSCredentials(id, pw);
        s3Client = new AmazonS3Client(awsCreds);
    }

    public void storeFile(String fileName) {
        Date date = new Date();
        s3Client.createBucket(date.toString());

    }
}
