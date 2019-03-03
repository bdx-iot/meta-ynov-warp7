require recipes-core/images/core-image-base.bb

SUMMARY = "Ynov Image (Test)"

inherit image-buildinfo

IMAGE_FEATURES_append = " \
	ssh-server-dropbear \
"

# Misc
IMAGE_INSTALL_append = " \
	openssh-sftp-server \
	iptables \
	curl \
	can-utils \
	iproute2 \
	i2c-tools \
"
	
# Kernel
IMAGE_INSTALL_append = " \
	kernel-image \
	kernel-devicetree \
	kernel-modules \
	haveged \ 
	packagegroup-base \
"
	
IMAGE_BUILDINFO_VARS = " \
    BB_VERSION \
    BUILD_SYS  \
    NATIVELSBSTRING \
    TARGET_SYS \
    MACHINE \
    DISTRO \
    DISTRO_VERSION \
    TUNE_FEATURES \
    TARGET_FPU \
"

buildinfo () {
cat > ${IMAGE_ROOTFS}${sysconfdir}/ynov-build-info << END
Build Configuration:
${@buildinfo_target(d)}
${@get_layer_revs(d)}
END
}	

export IMAGE_BASENAME = "ynov-image"
