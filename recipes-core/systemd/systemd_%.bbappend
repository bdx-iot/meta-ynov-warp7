FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://wifi.network \
	file://eth.network \
	file://rndis.network \
"

do_install_append() {
	install -m 0644 ${WORKDIR}/wifi.network ${D}${sysconfdir}/systemd/network/
	install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network/
	install -m 0644 ${WORKDIR}/rndis.network ${D}${sysconfdir}/systemd/network/
}
