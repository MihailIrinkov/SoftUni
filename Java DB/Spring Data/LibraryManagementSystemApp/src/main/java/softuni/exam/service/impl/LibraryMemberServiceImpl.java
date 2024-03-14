package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDTO;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: Implement all methods
@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private static String LIBRARY_MEMBERS_PATH = "src/main/resources/files/json/library-members.json";
    private final LibraryMemberRepository libraryMemberRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson, ModelMapper modelMapper, ValidationUtilsImpl validationUtils) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBERS_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<LibraryMemberImportDTO> membersList = Arrays.stream(gson.fromJson(readLibraryMembersFileContent(), LibraryMemberImportDTO[].class))
                .collect(Collectors.toList());

        for (LibraryMemberImportDTO l : membersList) {
            Optional<LibraryMember> libraryMember =
                    this.libraryMemberRepository.findByPhoneNumber(l.getPhoneNumber());

            if (libraryMember.isEmpty() && validationUtils.isValid(l)) {
                LibraryMember memberToSave = modelMapper.map(l, LibraryMember.class);
                this.libraryMemberRepository.save(memberToSave);

                sb.append(String.format("Successfully imported library member %s - %s%n",
                        memberToSave.getFirstName(), memberToSave.getLastName()));
            } else {
                sb.append("Invalid library member");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
