package builderExercise;

public class Contact {

    private String name;
    private String number;
    private String company;
    private String title;
    private String email;
    private String website;
    private String birthday;

    public Contact() {
    }

    public static ContactBuilder contactBuilder() {
        return new ContactBuilder();
    }
    public static class ContactBuilder {
        private Contact contact;

        private ContactBuilder() {
            this.contact = new Contact();
        }

        public ContactBuilder withName(String name) {
            contact.name = name;
            return this;
        }

        public ContactBuilder withNumber(String number) {
            contact.number = number;
            return this;
        }

        public ContactBuilder withCompany(String company) {
            contact.company = company;
            return this;
        }

        public Contact build() {
            return contact;
        }
    }

    //    public Contact(String name, String number) {
//        this.setName(name);
//        this.setNumber(number);
//    }
//
//    public Contact(String name, String number, String company) {
//        this(name, number);
//        this.company = company;
//    }
//
//    public Contact(String name, String number, String company, String title) {
//        this(name, number, company);
//        this.title = title;
//    }
//
//    public Contact(String name, String number, String company, String title, String email) {
//        this(name, number, company, title);
//        this.email = email;
//    }
//
//    public Contact(String name, String number, String company, String title, String email, String website) {
//        this(name, number, company, title, email);
//        this.website = website;
//    }
//
//    public Contact(String name, String number, String company, String title, String email, String website, String birthday) {
//        this(name, number, company, title, email, website);
//        this.birthday = birthday;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("") || name.length() < 2) {
            throw new IllegalStateException("The name must contain at least 2 characters!");
        }

        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || number.trim().equals("") || number.length() < 5) {
            throw new IllegalStateException("The name must contain at least 5 characters!");
        }

        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
