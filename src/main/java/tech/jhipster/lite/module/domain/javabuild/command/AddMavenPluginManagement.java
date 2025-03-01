package tech.jhipster.lite.module.domain.javabuild.command;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Optional;
import org.apache.commons.lang3.builder.ToStringBuilder;
import tech.jhipster.lite.module.domain.javabuildprofile.BuildProfileId;
import tech.jhipster.lite.module.domain.javadependency.JavaDependencyVersion;
import tech.jhipster.lite.module.domain.mavenplugin.MavenPlugin;
import tech.jhipster.lite.shared.error.domain.Assert;
import tech.jhipster.lite.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;

public final class AddMavenPluginManagement implements JavaBuildCommand, AddMavenPlugin {

  private final MavenPlugin plugin;
  private final Optional<JavaDependencyVersion> pluginVersion;
  private final Optional<BuildProfileId> buildProfile;

  private AddMavenPluginManagement(AddMavenPluginManagementBuilder builder) {
    Assert.notNull("plugin", builder.plugin);
    this.plugin = builder.plugin;
    this.pluginVersion = Optional.ofNullable(builder.pluginVersion);
    this.buildProfile = Optional.ofNullable(builder.buildProfile);
  }

  @Override
  public MavenPlugin plugin() {
    return plugin;
  }

  @Override
  public Optional<JavaDependencyVersion> pluginVersion() {
    return pluginVersion;
  }

  public Optional<BuildProfileId> buildProfile() {
    return buildProfile;
  }

  public static AddMavenPluginManagementPluginBuilder builder() {
    return new AddMavenPluginManagementBuilder();
  }

  private static class AddMavenPluginManagementBuilder
    implements AddMavenPluginManagementPluginBuilder, AddMavenPluginManagementOptionalBuilder {

    private MavenPlugin plugin;
    private JavaDependencyVersion pluginVersion;
    private BuildProfileId buildProfile;

    private AddMavenPluginManagementBuilder() {}

    @Override
    public AddMavenPluginManagementBuilder plugin(MavenPlugin plugin) {
      this.plugin = plugin;
      return this;
    }

    @Override
    public AddMavenPluginManagementOptionalBuilder pluginVersion(JavaDependencyVersion pluginVersion) {
      this.pluginVersion = pluginVersion;
      return this;
    }

    @Override
    public AddMavenPluginManagementOptionalBuilder buildProfile(BuildProfileId buildProfile) {
      this.buildProfile = buildProfile;
      return this;
    }

    public AddMavenPluginManagement build() {
      return new AddMavenPluginManagement(this);
    }
  }

  public interface AddMavenPluginManagementPluginBuilder {
    AddMavenPluginManagementOptionalBuilder plugin(MavenPlugin plugin);
  }

  public interface AddMavenPluginManagementOptionalBuilder {
    AddMavenPluginManagementOptionalBuilder pluginVersion(JavaDependencyVersion version);
    AddMavenPluginManagementOptionalBuilder buildProfile(BuildProfileId buildProfile);
    AddMavenPluginManagement build();
  }

  @Override
  @ExcludeFromGeneratedCodeCoverage
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, SHORT_PREFIX_STYLE)
      .append("plugin", plugin)
      .append("pluginVersion", pluginVersion.map(JavaDependencyVersion::toString).orElse("(empty)"));
    return builder.toString();
  }
}
