# Setting up your local machine for development

## Installing Java / Kotlin / Micronaut

Configure sdkman to manage your sdk for this project. call sdkman's install script directly with this one liner: 

```sh
curl -s "https://get.sdkman.io" | bash
```

Once installed, call `sdk env` to force your sdk shell to recognize the default sdk versions.

## Testing Dependencies

Micronaut tests are awesome and use [testcontainers](https://java.testcontainers.org/) under the hood. This will require docker to be installed on your system. Feel free to add to these directions if the solution for you system isn't mentioned below.

<details><summary>Fedora</summary>

> :NOTE: instructions pulled from [docker's website](https://docs.docker.com/engine/install/fedora/). A summarised bash script is available at the end of this section.

#### Remove any older versions (may be present from yum default or other repos)

```sh
sudo dnf remove docker \
	docker-client \
	docker-client-latest \
	docker-common \
	docker-latest \
	docker-latest-logrotate \
	docker-logrotate \
	docker-selinux \
	docker-engine-selinux \
	docker-engine
```
It's all good if dnf reports that nothing was removed / it didn't find some of these.

#### Add and enable docker rpm repo

When installing, validate the fingerprint matches `060A 61C5 1B55 8A7F 742B 77AA C52F EB6B 621E 9F35`. 

```sh
sudo dnf -y install dnf-plugins-core
sudo dnf config-manager --add-repo https://download.docker.com/linux/fedora/docker-ce.repo
```

#### Install docker's latest version

```sh
sudo dnf install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin docker-compose
```

#### Starting Docker
Docker runs as a daemon, so you have start it with systemctl. If you dont want to worry about starting the daemon in the future, you can enable it (this sets it to run when your computer boots up).

##### Start daemon
```
sudo systemctl start docker
```

##### Enable daemon
```
sudo systemctl enable docker
```

<details><summary>Install Script</summary>

```bash
#!/usr/bin/env bash

# Remove any previous docker installations
sudo dnf remove docker docker-client docker-client-latest docker-common docker-latest docker-latest-logrotate docker-logrotate docker-selinux docker-engine-selinux docker-engine

# Install package manager for adding repos (if not already installed)
sudo dnf -y install dnf-plugins-core

# Add Docker CE repository
sudo dnf config-manager --add-repo https://download.docker.com/linux/fedora/docker-ce.repo

# Verify fingerprint (should match 060A 61C5 1B55 8A7F 742B 77AA C52F EB6B 621E 9F35)

# Install Docker and related packages
sudo dnf install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin docker-compose

# Start Docker service
sudo systemctl start docker

# Enable Docker to start on boot
sudo systemctl enable docker

echo "Docker installation complete!"
```

</details>
</details>

<details><summary>Windows</summary>

Install using winget with winget. If you dont have winget, it is worth taking the time to configure it now.

```PowerShell
winget install -e --id Docker.DockerDesktop
```
</details>
