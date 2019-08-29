#!/usr/bin/env bash

# (-f flag to bypass the prompt.)

# WARNING! This will remove:
#         - all stopped containers
#         - all networks not used by at least one container
#         - all dangling images
#         - all build cache
docker system prune -f

# Remove images not referenced by any container
docker image prune -a -f

# Remove unused volumes
docker volume prune -f
