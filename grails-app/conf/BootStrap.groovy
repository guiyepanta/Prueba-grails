class BootStrap {

    def init = { servletContext ->
		new CellPhoneModel(name: "Nokia Lumia 900").save()
		new CellPhoneModel(name: "Galaxy Note II").save()
    }
    def destroy = {
    }
}
