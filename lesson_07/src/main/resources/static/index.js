angular.module('students', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $scope.editMode = false;
        $http({
            url: 'http://localhost:8189/student-base/api/v1/students',
            method: 'GET'
        }).then(function (response) {
            $scope.studentsList = response.data;
        });
    };

    $scope.deleteStudent = function (id) {
        $http.delete('http://localhost:8189/student-base/api/v1/students/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewStudent = function () {
    // console.log($scope.newStudent);
    $http.post('http://localhost:8189/student-base/api/v1/students', $scope.newStudent)
        .then(function (response) {
            $scope.newStudent = null;
            $scope.fillTable();
        });
    }

    $scope.showEditForm = function (id) {
        $scope.editedId = id;
        $scope.editMode = true;
    }

    $scope.isEditModeEnabled = function () {
        return $scope.editMode;
    }

    $scope.editStudent = function () {
        $scope.editedStudent.id = $scope.editedId;
        $http.post('http://localhost:8189/student-base/api/v1/students/' + $scope.editedId, $scope.editedStudent)
            .then(function (response) {
                alert('Студент ' + $scope.editedStudent.fullName + ' успешно изменен');
                $scope.editedStudent = null;
                $scope.fillTable();
            });
    }

    $scope.fillTable();
});





