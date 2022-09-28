import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2_0_04 {
    public static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> articleList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String title = input.split("\\, ")[0];
            String content = input.split("\\, ")[1];
            String author = input.split(" ")[2];

            Article article = new Article(title, content, author);
            articleList.add(article);
        }
        String printType = scanner.nextLine();
        for (Article article : articleList) {
            switch (printType) {
                case "content":
                case "title":
                case "author":
                    System.out.println(article.toString());
            }
        }
    }
}
