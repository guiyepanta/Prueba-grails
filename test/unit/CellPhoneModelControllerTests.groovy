

import org.junit.*
import grails.test.mixin.*

@TestFor(CellPhoneModelController)
@Mock(CellPhoneModel)
class CellPhoneModelControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/cellPhoneModel/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.cellPhoneModelInstanceList.size() == 0
        assert model.cellPhoneModelInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.cellPhoneModelInstance != null
    }

    void testSave() {
        controller.save()

        assert model.cellPhoneModelInstance != null
        assert view == '/cellPhoneModel/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/cellPhoneModel/show/1'
        assert controller.flash.message != null
        assert CellPhoneModel.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/cellPhoneModel/list'

        populateValidParams(params)
        def cellPhoneModel = new CellPhoneModel(params)

        assert cellPhoneModel.save() != null

        params.id = cellPhoneModel.id

        def model = controller.show()

        assert model.cellPhoneModelInstance == cellPhoneModel
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/cellPhoneModel/list'

        populateValidParams(params)
        def cellPhoneModel = new CellPhoneModel(params)

        assert cellPhoneModel.save() != null

        params.id = cellPhoneModel.id

        def model = controller.edit()

        assert model.cellPhoneModelInstance == cellPhoneModel
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/cellPhoneModel/list'

        response.reset()

        populateValidParams(params)
        def cellPhoneModel = new CellPhoneModel(params)

        assert cellPhoneModel.save() != null

        // test invalid parameters in update
        params.id = cellPhoneModel.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/cellPhoneModel/edit"
        assert model.cellPhoneModelInstance != null

        cellPhoneModel.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/cellPhoneModel/show/$cellPhoneModel.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        cellPhoneModel.clearErrors()

        populateValidParams(params)
        params.id = cellPhoneModel.id
        params.version = -1
        controller.update()

        assert view == "/cellPhoneModel/edit"
        assert model.cellPhoneModelInstance != null
        assert model.cellPhoneModelInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/cellPhoneModel/list'

        response.reset()

        populateValidParams(params)
        def cellPhoneModel = new CellPhoneModel(params)

        assert cellPhoneModel.save() != null
        assert CellPhoneModel.count() == 1

        params.id = cellPhoneModel.id

        controller.delete()

        assert CellPhoneModel.count() == 0
        assert CellPhoneModel.get(cellPhoneModel.id) == null
        assert response.redirectedUrl == '/cellPhoneModel/list'
    }
}
