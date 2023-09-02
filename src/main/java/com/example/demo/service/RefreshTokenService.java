//package com.example.demo.service;
//
//import java.time.Instant;
//import java.util.Optional;
//import java.util.UUID;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.RefreshToken;
//import com.example.demo.entity.TokenRefreshException;
//import com.example.demo.repository.DeveloperRepo;
//import com.example.demo.repository.RefreshTokenRepo;
//
//@Service
//public class RefreshTokenService {
//	 @Value("${bezkoder.app.jwtRefreshExpirationMs}")
//	  private Long refreshTokenDurationMs;
//
//	  @Autowired
//	  private RefreshTokenRepo refreshTokenRepo;
//
//	  @Autowired
//	  private DeveloperRepo developerRepo;
//
//	  public Optional<RefreshToken> findByToken(String token) {
//	    return Optional.ofNullable(refreshTokenRepo.findByToken(token));
//	  }
//
//	  public RefreshToken createRefreshToken(Integer userid) {
//		  RefreshToken refreshToken = new RefreshToken();
//
//		    refreshToken.setUser(developerRepo.findById(userid).get());
//		    refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
//		    refreshToken.setToken(UUID.randomUUID().toString());
//
//		    refreshToken = refreshTokenRepo.save(refreshToken);
//		    return refreshToken;
//	  }
//	  public RefreshToken verifyExpiration(RefreshToken token) {
//		    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
//		    	refreshTokenRepo.delete(token);
//		      throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
//		    }
//
//		    return token;
//		  }
//
//	  @Transactional
//	  public int deleteByUserId(Integer userid) {
//	    return refreshTokenRepo.deleteByuser(developerRepo.findByUserid(userid).get());
//	  }
//
//}
