package cloudcode.realestatechecker.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class CheckRequestDto {
    String test;
}
