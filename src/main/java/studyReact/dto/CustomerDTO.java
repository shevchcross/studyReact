package studyReact.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
public class CustomerDTO {

    private Long id;

    private TicketDTO ticket;

    public CustomerDTO() {
    }
}
