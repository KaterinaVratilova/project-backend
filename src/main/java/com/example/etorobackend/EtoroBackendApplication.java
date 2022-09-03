package com.example.etorobackend;

import com.example.etorobackend.assets.entities.AssetEntity;
import com.example.etorobackend.assets.entities.AssetTypeEntity;
import com.example.etorobackend.assets.enums.AssetTypes;
import com.example.etorobackend.assets.repositories.AssetRepository;
import com.example.etorobackend.assets.repositories.AssetTypeRepository;
import com.example.etorobackend.roles.entities.RoleEntity;
import com.example.etorobackend.roles.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class EtoroBackendApplication {

	private final RoleRepository roleRepository;

	private final AssetTypeRepository assetTypeRepository;

	private final AssetRepository assetRepository;

	@Autowired
	public EtoroBackendApplication(
			RoleRepository roleRepository,
			AssetTypeRepository assetTypeRepository,
			AssetRepository assetRepository
	) {
		this.roleRepository = roleRepository;
		this.assetTypeRepository = assetTypeRepository;
		this.assetRepository = assetRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EtoroBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@GetMapping
	public String hello() {
		return "Server is running";
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			try {
				roleRepository.saveAll(List.of(
						new RoleEntity("ADMIN"),
						new RoleEntity("USER_BASIC"),
						new RoleEntity("USER_ADVANCED")
				));

				assetTypeRepository.saveAll(List.of(
						new AssetTypeEntity(AssetTypes.STOCKS),
						new AssetTypeEntity(AssetTypes.CRYPTO),
						new AssetTypeEntity(AssetTypes.INDICES),
						new AssetTypeEntity(AssetTypes.ETFS),
						new AssetTypeEntity(AssetTypes.COMMODITIES),
						new AssetTypeEntity(AssetTypes.CURRENCIES)
				));

				var stocks = assetTypeRepository.findByType(AssetTypes.STOCKS);

				assetRepository.saveAll(List.of(
					new AssetEntity("INTEL", "INTC", stocks),
					new AssetEntity("Coca-cola", "KO", stocks)
				));
			} catch (Exception e) {

			}
		};
	}

}
