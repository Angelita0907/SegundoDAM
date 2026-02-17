from odoo import models, fields, api

class SalaReuniones(models.Model):
    _name = 'sala.reuniones'
    _description = 'Sala de Reuniones'
    _order = 'name asc'

    name = fields.Char(string = 'Salas',required=True, index = True)
    description = fields.Text(string = 'Descripción')
    
    # Relación One2many con Reunión
    reuniones_ids = fields.One2many(
        comodel_name='reuniones',  
        inverse_name='sala_id',           
        string='Reuniones',
        help='Reuniones celebradas en esta sala'
    )