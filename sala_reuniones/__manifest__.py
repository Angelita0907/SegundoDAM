{
    'name': "Sala Reuniones",

    'summary': "Salas de reuniones de la empresa",

    'description': """
        Módulo de gestión de salas de reuniones
        ========================================
        
        Este módulo permite:
        * Crear y gestionar salas de reuniones
        * Programar reuniones en las salas
        * Asignar responsables y asistentes
        * Calcular el porcentaje de ocupación de las reuniones
    """,

    'author': "Sala Reuniones",
    'website': "https://www.yourcompany.com",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/15.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'tools',
    'license': 'LGPL-3',
    'version': '1.0',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'security/ir.model.access.csv',
        'views/sala_reuniones_views.xml',
        'views/reuniones_views.xml',
        
    ],

    'installable': True,
    'application': True,

}

