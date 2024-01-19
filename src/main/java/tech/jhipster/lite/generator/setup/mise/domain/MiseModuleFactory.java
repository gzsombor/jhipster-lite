package tech.jhipster.lite.generator.setup.mise.domain;

import static tech.jhipster.lite.module.domain.JHipsterModule.from;
import static tech.jhipster.lite.module.domain.JHipsterModule.moduleBuilder;
import static tech.jhipster.lite.module.domain.JHipsterModule.to;

import tech.jhipster.lite.module.domain.JHipsterModule;
import tech.jhipster.lite.module.domain.file.JHipsterSource;
import tech.jhipster.lite.module.domain.javabuild.VersionSlug;
import tech.jhipster.lite.module.domain.javadependency.JavaDependenciesVersionsRepository;
import tech.jhipster.lite.module.domain.npm.NpmVersions;
import tech.jhipster.lite.module.domain.properties.JHipsterModuleProperties;

public class MiseModuleFactory {

  private static final JHipsterSource SOURCE = from("setup/mise");

  private final NpmVersions npmVersions;
  private final JavaDependenciesVersionsRepository javaDependenciesRepository;

  public MiseModuleFactory(NpmVersions npmVersions, JavaDependenciesVersionsRepository javaDependenciesRepository) {
    this.npmVersions = npmVersions;
    this.javaDependenciesRepository = javaDependenciesRepository;
  }

  public JHipsterModule build(JHipsterModuleProperties properties) {
    var nodeVersion = npmVersions.getNodeVersion().split("\\.");
    var mavenVersion = javaDependenciesRepository.get().get(new VersionSlug("maven.version")).version().get();
    return moduleBuilder(properties)
      .context()
      .put("nodeVersion", nodeVersion[0] + '.' + nodeVersion[1])
      .put("mavenVersion", mavenVersion)
      .and()
      .files()
      .add(SOURCE.template("mise.toml"), to(".mise.toml"))
      .and()
      .build();
  }
}
