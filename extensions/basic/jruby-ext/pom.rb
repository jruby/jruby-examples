project 'jruby-ext' do

  model_version '4.0.0'
  id 'com.purbon:jruby-ext:1.3.0'
  packaging 'jar'

  description 'example JRuby extension'

  developer 'purbon' do
    name 'Pere Urbón'
    email 'pere.urbon@gmail.com'
    roles 'developer'
  end

  issue_management 'https://github.com/jruby/jruby-examples/issues', 'Github'

  source_control(
    url: 'https://github.com/jruby/jruby-examples',
    connection: 'scm:git:git://github.com/jruby/jruby-examples.git',
    developer_connection: 'git@github.com:jruby/jruby-examples.git'
  )

  properties(
    'maven.compiler.source' => '1.8',
    'maven.compiler.target' => '1.8',
    'source.directory' => 'src/main/java', # poxy Eclipse folders
    'project.build.sourceEncoding' => 'utf-8',
    'polyglot.dump.pom' => 'pom.xml',
    'jruby.api' => 'http://jruby.org/apidocs/',
  )

  jar 'org.jruby:jruby-base:9.3.0.0'

  plugin_management do
    plugin :resources, '3.1.0'
    plugin :dependency, '3.1.1'
    plugin(
      :compiler, '3.8.1',
      source: '${maven.compiler.source}',
      target: '${maven.compiler.target}'
    )
    plugin(
      :javadoc, '2.10.4',
      detect_offline_links: 'false',
      links: ['${jruby.api}']
    )
    plugin(
      :jar, '3.1.1',      
      archive: {
        manifestFile: 'MANIFEST.MF' # camel case reqd
      }
    )
  end

  build do
    default_goal 'package'
    source_directory '${source.directory}'
    final_name 'jruby-ext'
  end
end
