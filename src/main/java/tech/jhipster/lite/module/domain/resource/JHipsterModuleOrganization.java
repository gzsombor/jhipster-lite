package tech.jhipster.lite.module.domain.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import tech.jhipster.lite.generator.slug.domain.JHLiteModuleSlug;
import tech.jhipster.lite.module.domain.JHipsterFeatureSlug;
import tech.jhipster.lite.module.domain.landscape.JHipsterLandscapeDependency;
import tech.jhipster.lite.shared.error.domain.Assert;

public final class JHipsterModuleOrganization {

  public static final JHipsterModuleOrganization STANDALONE = builder().build();
  public static final JHipsterModuleOrganization SPRINGBOOT_DEPENDENCY = builder().addDependency(JHLiteModuleSlug.SPRING_BOOT).build();

  private final Optional<JHipsterFeatureSlug> feature;
  private final Collection<JHipsterLandscapeDependency> dependencies;
  private final Collection<JHipsterLandscapeDependency> exclusions;

  private JHipsterModuleOrganization(JHipsterModuleOrganizationBuilder builder) {
    feature = builder.feature;
    dependencies = builder.dependencies;
    exclusions = builder.exclusions;
  }

  public static JHipsterModuleOrganizationBuilder builder() {
    return new JHipsterModuleOrganizationBuilder();
  }

  public Optional<JHipsterFeatureSlug> feature() {
    return feature;
  }

  public Collection<JHipsterLandscapeDependency> dependencies() {
    return dependencies;
  }

  public Collection<JHipsterLandscapeDependency> exclusions() {
    return exclusions;
  }

  public static class JHipsterModuleOrganizationBuilder {

    private final Collection<JHipsterLandscapeDependency> dependencies = new ArrayList<>();
    private final Collection<JHipsterLandscapeDependency> exclusions = new ArrayList<>();
    private Optional<JHipsterFeatureSlug> feature = Optional.empty();

    public JHipsterModuleOrganizationBuilder feature(JHipsterFeatureSlugFactory feature) {
      Assert.notNull("feature", feature);

      this.feature = feature.build();

      return this;
    }

    public JHipsterModuleOrganizationBuilder addDependency(JHipsterModuleSlugFactory module) {
      Assert.notNull("module", module);

      dependencies.add(module.toModuleDependency());

      return this;
    }

    public JHipsterModuleOrganizationBuilder addDependency(JHipsterFeatureSlugFactory feature) {
      Assert.notNull("feature", feature);

      feature.toFeatureDependency().ifPresent(dependencies::add);

      return this;
    }

    public JHipsterModuleOrganizationBuilder addExclusion(JHipsterModuleSlugFactory module) {
      Assert.notNull("module", module);

      exclusions.add(module.toModuleDependency());

      return this;
    }

    public JHipsterModuleOrganizationBuilder addExclusion(JHipsterFeatureSlugFactory feature) {
      Assert.notNull("feature", feature);

      feature.toFeatureDependency().ifPresent(exclusions::add);

      return this;
    }

    public JHipsterModuleOrganization build() {
      return new JHipsterModuleOrganization(this);
    }
  }
}
