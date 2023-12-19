import java.nio.file.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Utils {
    // a. Viết phương thức static để đọc một tệp .txt từ ổ cứng:
    public static String readContentFromFile(String path) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    // b. Viết phương thức static để xuất nội dung một xâu vào 1 tệp trong ổ cứng:
    public static void writeContentToFile(String path, String content) {
        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // c. Tương tự ý câu b nhưng thay vì xóa nội dung cũ đi, ta bổ sung nội dung mới vào cuối tệp hiện tại
    public static void appendContentToFile(String path, String content) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // d. Viết phương thức static để tìm kiếm một tệp trong một thư mục:
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }

}
