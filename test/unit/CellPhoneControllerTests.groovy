

import org.junit.*
import grails.test.mixin.*

@TestFor(CellPhoneController)
@Mock(CellPhone)
class CellPhoneControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/cellPhone/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.cellPhoneInstanceList.size() == 0
        assert model.cellPhoneInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.cellPhoneInstance != null
    }

    void testSave() {
        controller.save()

        assert model.cellPhoneInstance != null
        assert view == '/cellPhone/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/cellPhone/show/1'
        assert controller.flash.message != null
        assert CellPhone.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/cellPhone/list'

        populateValidParams(params)
        def cellPhone = new CellPhone(params)

        assert cellPhone.save() != null

        params.id = cellPhone.id

        def model = controller.show()

        assert model.cellPhoneInstance == cellPhone
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/cellPhone/list'

        populateValidParams(params)
        def cellPhone = new CellPhone(params)

        assert cellPhone.save() != null

        params.id = cellPhone.id

        def model = controller.edit()

        assert model.cellPhoneInstance == cellPhone
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/cellPhone/list'

        response.reset()

        populateValidParams(params)
        def cellPhone = new CellPhone(params)

        assert cellPhone.save() != null

        // test invalid parameters in update
        params.id = cellPhone.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/cellPhone/edit"
        assert model.cellPhoneInstance != null

        cellPhone.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/cellPhone/show/$cellPhone.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        cellPhone.clearErrors()

        populateValidParams(params)
        params.id = cellPhone.id
        params.version = -1
        controller.update()

        assert view == "/cellPhone/edit"
        assert model.cellPhoneInstance != null
        assert model.cellPhoneInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/cellPhone/list'

        response.reset()

        populateValidParams(params)
        def cellPhone = new CellPhone(params)

        assert cellPhone.save() != null
        assert CellPhone.count() == 1

        params.id = cellPhone.id

        controller.delete()

        assert CellPhone.count() == 0
        assert CellPhone.get(cellPhone.id) == null
        assert response.redirectedUrl == '/cellPhone/list'
    }
}
