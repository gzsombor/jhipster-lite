package tech.jhipster.lite.module.domain.resource;

import java.util.Optional;
import tech.jhipster.lite.module.domain.JHipsterFeatureSlug;
import tech.jhipster.lite.module.domain.landscape.JHipsterFeatureDependency;

@FunctionalInterface
public interface JHipsterFeatureSlugFactory {
  String get();

  default Optional<JHipsterFeatureSlug> build() {
    return JHipsterFeatureSlug.of(get());
  }

  default Optional<JHipsterFeatureDependency> toFeatureDependency() {
    return build().map(JHipsterFeatureDependency::new);
  }
}
