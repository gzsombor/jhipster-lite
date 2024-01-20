package tech.jhipster.lite.module.domain.resource;

import tech.jhipster.lite.module.domain.JHipsterModuleSlug;
import tech.jhipster.lite.module.domain.landscape.JHipsterModuleDependency;

@FunctionalInterface
public interface JHipsterModuleSlugFactory {
  String get();

  default JHipsterModuleSlug build() {
    return new JHipsterModuleSlug(get());
  }

  default JHipsterModuleDependency toModuleDependency() {
    return new JHipsterModuleDependency(build());
  }
}
