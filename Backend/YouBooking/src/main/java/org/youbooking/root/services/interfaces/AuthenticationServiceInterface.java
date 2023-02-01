package org.youbooking.root.services.interfaces;

import org.youbooking.root.services.dtos.auth.AuthenticationRequestDto;
import org.youbooking.root.services.dtos.auth.AuthenticationResponse;
import org.youbooking.root.services.dtos.auth.RegisterRequestDto;

public interface AuthenticationServiceInterface {
    AuthenticationResponse register(RegisterRequestDto request);
    Object authenticate(AuthenticationRequestDto request);
}
