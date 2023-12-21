package bg.softuni.mvcdemo.dto.categories;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyImportDto {

    @XmlAttribute(name = "name")
    private String name;

    public CompanyImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
