package tech.jhipster.lite.generator.setup.mise.infrastructure;

import static tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug.FRONTEND_MAVEN_PLUGIN;
import static tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug.GRADLE_WRAPPER;
import static tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug.MAVEN_WRAPPER;
import static tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug.MISE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.setup.mise.domain.MiseModuleFactory;
import tech.jhipster.lite.module.domain.javadependency.JavaDependenciesVersionsRepository;
import tech.jhipster.lite.module.domain.npm.NpmVersions;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
public class MiseModuleConfiguration {

  @Bean
  JHipsterModuleResource miseModule(MiseModuleFactory mise) {
    return JHipsterModuleResource.builder()
      .slug(MISE)
      .withoutProperties()
      .apiDoc("Mise", "Add support for Mise environment management")
      .organization(
        JHipsterModuleOrganization.builder()
          .addExclusion(MAVEN_WRAPPER)
          .addExclusion(GRADLE_WRAPPER)
          .addExclusion(FRONTEND_MAVEN_PLUGIN)
          .build()
      )
      .tags("setup", "init")
      .factory(mise::build);
  }

  @Bean
  MiseModuleFactory mise(NpmVersions npmVersions, JavaDependenciesVersionsRepository javaDependenciesVersionsRepository) {
    return new MiseModuleFactory(npmVersions, javaDependenciesVersionsRepository);
  }
}
